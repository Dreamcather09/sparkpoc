/*
val name = "vaibhav"
val age = 28

print(s"Hi I am $name, I am $age years old")
print("Hi, my name is %s and I am %d years old".format(name,age))
------------------------------------------------------------
val array = Array(1,2,3,4,5,6)
for (x<- array) yield x*x
------------------------------------------------------------
val names = Array("vaibhav","john","merry","shawn")

for (x<- names) yield (x.toUpperCase)

for(x<- names if(x.length >4)) yield x.toUpperCase
//Using case class
for(x<-names if(x!="")) yield x match{
  case x if(x.length >4) => x.toUpperCase()
  case _=>x
}
----------------------------------------------------------------------
val num1 = 1 to 20 toArray
val num2 = 1 to 10 toArray
//for(x<- num1; y<-num2) println(s"$x * $y = ${x*y}")

for (x<- num1 if(x%2==0)) yield x
-----------------------------------------------------------------
val arr = Array(1,4,5,3,7,-3,-9,66)
for(x<- arr if(x>0)) yield x match  {
  case x if(x%2==0)=>x*x
  case _=> x*x*x
}
------------------------------------------------------------------
val tup =("Macy",23,"CA")
val names = Array("David","Maria","Steve","Lisa")
val msg1 = s"Hi, ${tup._1} welcome to ${tup._3}"
val msg2 = s"Hi, ${names(0)} welcome"
-----------------------------------------------------------------
def offer(abc:(String,Int,String)) = abc match {
  case(n,a,c) if (a>18 && c=="NJ" ) =>s"Hi $n you will get 10% off"
  case(n,a,c) if (a>18 && c =="CA") => s"Hi $n you will get 20% off"
  case _=>s"${abc._1} no offer "

}
offer("vaibhav",23,"CA")
-------------------------------------------------------------------------------------
val day ="sun"
def todayOffer(day:String) = day match{
  case "sun" | "sunday" =>1
  case "mon" | "monday" =>2
  case "tue" | "tuesday" =>3
  case "wed" | "wednesday" =>4
  case "thus" | "thursday"=> 5
  case "fri"  | "friday" =>6
  case "sat" | "saturday" =>7
  case _=> day

}
todayOffer("fri")
 */
