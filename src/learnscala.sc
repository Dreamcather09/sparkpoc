val name = "vaibhav"
val Arr = Array("Pune","Delhi","Chennai","Mumbai")
val age = 28
val city = "Newyork"
val sal = 10000
//string interpolation must use s "double quotes" here s is mandit
//anywhere if u have $ means its refer something
val msg = s"Hi $name, welcome to $city, your age:$age your salalry $sal so you will get ${sal*10/100} money back "
//2nd way 2nd prefer approach
val msg1 = "Hi %s, your sal %d welcome to %s".format(name,sal,city)

val message = "Hi, my house number 5\n from \tirupati"

val startdate = "2020-Mar-30"
val enddate= "2020-Apr-07"
val regionquery =
  s"""select '$msg' Recency_Date,'APP' Project,'All' Show, 'All' SBU,'All' language,  case when v.region is null then 'Not Tagged' else v.region end region,count(distinct(distinct_id)) viewers
From voot_app_base v
Where v.event = ('mediaReady') and
date_stamp between $startdate and $enddate
group by region"""
