grammar Hello;               // 1、定义文法的名字
@header { package com.algorithm.leetcode.antlr; }  //2、java package

s  : 'hello' ID ;            // 3、匹配关键字hello和标志符
ID : [a-z]+ ;                // 标志符由小写字母组成
WS : [ \t\r\n]+ -> skip ;