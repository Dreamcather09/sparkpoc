/*Q.1 Find the largest word length from given data
//Method 1
val data = "Honest is the best policy"
val a = data.split(" ")
val b = a.map(x=>x.length()).max
for (x <- a if(x.length >=b)) yield x

//Method 2

val info = "Need is the mother of invention"
val r = info.split(" ")
val s = r.maxBy(x => x.length)
s.split(" ").map(_.trim).map(x=>(x.length,x)).max
----------------------------------------------------------------


//Q2. create a function based on these conditions
//if name contains ... remove that space and get a name without Space ... let eg: "venu testing" ... venutesting
//if name length 4 or below 4, reverse that name ... let eg: venu .... unev
//if name length between 5-20 change to upper case ... let eg: venukatragadda ...VENUKATRAGADDA
//if name length more than 20 characters .. remove remaining letters (slice)
//let eg: "venukatragaddaandtestingonly"

def myString(name:String) ={
  if (name.contains(" ")) {
    name.replace(" ",",")
  }
  else if(name.length <=4) {name.reverse}
  else if(name.length >= 5 && name.length<=20) {name.toUpperCase}
  else if(name.length >20) {name.substring(0,20)}
}
val data = "vaibhav"
println("mystring is:"+myString(data))

*/


