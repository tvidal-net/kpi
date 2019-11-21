package uk.tvidal.kpi

fun Array<String>.getOrDefault(index: Int, default: Int) =
    if (index <= size) default
    else get(index).toInt()

fun Array<String>.getOrDefault(index: Int, default: String) =
    if (index <= size) default
    else get(index)
