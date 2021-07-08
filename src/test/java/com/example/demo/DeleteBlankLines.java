//package com.example.demo;
//
//public class DeleteBlankLines {
//
//    public static void main(String[] args) {
//        String input="aa\r\n\t\r\nbb\r\n\r\n\r\ncc\r\naa\n\nbb\n\n\ncc\n";
//        System.out.println(input);
//        System.out.println("--------------------------------------");
//        System.out.println(deleteCRLF(input));
//    }
//
//
//    /***
//     * delete CRLF; delete  empty line ;delete blank lines
//     *
//     * @param input
//     * @return
//     */
//    private static String deleteCRLFOnce(String input) {
//
//        return input.replaceAll("((\\r\\n)|\\n)[\\s\\t ]*(\\1)+", "$1");
//
//    }
//
//    /**
//     * delete CRLF; delete  empty line ;delete blank lines
//     *
//     * @param input
//     * @return
//     */
//    public static String deleteCRLF(String input) {
//        input=deleteCRLFOnce(input);
//        return deleteCRLFOnce(input);
//    }
//}
