package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import org.junit.platform.commons.util.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatcherSql {
    public static void main(String[] args) {

//        String str = "REPLACE VIEW ${aaaa}.bbbb " +
//                "TABLE ${aaaa}.bbbb" +
//                "COMMENT ON TABLE ${aaaa}.bbbb IS '萨芬士大夫';" +
//                "COMMENT ON TABLE ${aaaa}.bbbb IS '萨芬士大夫';" +
//                "COMMENT ON VIEW ${aaaa}.bbbb IS '萨芬士大夫1';";

        String str = "REPLACE VIEW ${sfds}.sfs";
        HashSet<Map<String,String>> set1 = convertName(str);
        System.out.println(JSONObject.toJSONString(set1));
        HashSet<Map<String,String>> set2 = getRemarkComment(str);
        System.out.println(JSONObject.toJSONString(set2));

        HashSet<Map<String,String>> resultSet = new HashSet<>();
        Iterator<Map<String,String>> it1 = set1.iterator();
        while(it1.hasNext()){
            Map<String,String> map1 = it1.next();
            Iterator<Map<String,String>> it2 = set2.iterator();
            while(it2.hasNext()){
                Map<String,String> map2 = it2.next();
                String tableRemark = map2.get("tableRemark");
                map2.remove("tableRemark");
                if(map1.equals(map2)){
                    map1.put("tableRemark",tableRemark);
                }
                map2.put("tableRemark",tableRemark);
            }
            resultSet.add(map1);
        }
        System.out.println(JSONObject.toJSONString(resultSet));
    }

    public static HashSet<Map<String,String>> convertName(String connet){
        Matcher matcher = Pattern.compile("(?:FROM|JOIN|VIEW|TABLE)\\s+[\\w\\${\\}]*\\.?\\[?(\\b\\w+)\\]*")
                .matcher(connet);
        HashSet hs = new HashSet();
        while (matcher.find()){
            hs.add(convertToMap(matcher.group()));
        }
        return hs;
    }

    public static HashSet<Map<String,String>> getRemarkComment(String content){
        HashSet<String> hs = new HashSet();
        Matcher matcher = Pattern.compile("(?:COMMENT ON TABLE|COMMENT ON VIEW)+(.+?)(?=\\;)").matcher(content);
        while (matcher.find()){
            hs.add(matcher.group());
        }
        HashSet<Map<String,String>> hsResult = new HashSet();
        Map<String,String> mapResult = null;
        if(hs != null && hs.size()>0){
            Iterator iterator = hs.iterator();
            while (iterator.hasNext()){
                mapResult = new HashMap<>();
                String con = (String) iterator.next();
                if(StringUtils.isNotBlank(con)){
                    //库名、表名
                    Matcher matchers = Pattern.compile("(?:FROM|JOIN|VIEW|TABLE)\\s+[\\w\\${\\}]*\\.?\\[?(\\b\\w+)\\]*").matcher(con);
                    while (matchers.find()){
                        mapResult = convertToMap(matchers.group());
                    }
                    //表注释
                    String tableRemark = "";
                    Matcher matcherCon = Pattern.compile("\'(.*?)\'").matcher(con);
                    while (matcherCon.find()){
                        tableRemark = matcherCon.group();
                    }
                    String finalTableRemark = tableRemark;
                    mapResult.put("tableRemark", finalTableRemark);
                    //类型
                    String type = con.substring(11,16);
                    mapResult.put("type", type.trim());
                }
                hsResult.add(mapResult);
            }
        }
        return hsResult;
    }

    public static Map<String,String> convertToMap(String content){
        Map<String,String> map = new HashMap<>();
        List list = Arrays.asList(content.split("\\."));
        for(int i=0;i<list.size();i++){
            if(i==0){
                Matcher matcher = Pattern.compile("(?<=\\{)(.+?)(?=\\})").matcher(list.get(i)+"");
                while (matcher.find()){
                    map.put("dbNme",matcher.group());
                }
            }else{
                map.put("tableName",list.get(1)+"");
            }
        }
        //类型
        String type = content.substring(0,5);
        map.put("type",type.trim());
        return map;
    }
}
