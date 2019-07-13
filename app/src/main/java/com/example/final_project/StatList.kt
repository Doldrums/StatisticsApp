package com.example.final_project

interface StatList {

}

data class StatDescr(
    val text:String
):StatList{}

class StatData(
    val text:String,
    val points:String
):StatList{}
