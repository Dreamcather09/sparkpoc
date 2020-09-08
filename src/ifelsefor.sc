/*
//if else example
val age = 14
val name = "shruti"
val gender = "Female"
//val vot_id = (if age>=18) s"HI $name, your $age welcome to utilize ur vote"

val marriage_cert = if(age>=18 && gender=="Female") "you eligible to marry"
else if (age>=21 && gender=="Female") "you are eligible to marry"
else if(age <=16 && gender=="Female") "if you marry is crime"
else "your are not "


val age =77
val gender = "female"
val offer =if(age >0 && age <7) "you will get 20% off on J&J products"
else if (age>=7 && age <= 17) "if u will spend 100USD will get 40% off"
else if(age>=17 && gender =="female" && age<40) "you will get 30% off on cosmetics "
else if (age>=17 && gender =="male" && age <50) "you will get 36% off on sportsware"
else "no offer"

def offer(age:Int):String = if(age >0 && age <7) "you will get 20% off on J&J products"
else if (age>=7 && age <= 17) "if u will spend 100USD will get 40% off"
else if(age>=17 && gender =="female" && age<40) "you will get 30% off on cosmetics "
else if (age>=17 && gender =="male" && age <50) "you will get 36% off on sportsware"
else "no offer"
offer(age = 33)
//Match Examples
val name = "shruti"
val age = 50
//Your emp
val task = name.toLowerCase() match {
  case "venu" => s"Hi $name pls complete admin task"
  case "vaibhav" => s"hi $name pls complete reporting task"
  case "shruti" => s"Hi $name please complete development task"
  case "pooja" => s"Hi $name please complete testing task"
  case _=> s"Hi $name you are not member in this group "
}

val emp = ("")

*/



val marks = 0

def pass(marks:Int)= marks match {
  case x if(marks >85) =>"Distinction "
  case x if(marks >=70 && marks<85) => "Grade A"
  case x if(marks >=60 && marks <70) =>"Grade B"
  case x if (marks >=50 && marks<60) =>"Grade C"
  case _ =>"Fail"

}
pass(64)