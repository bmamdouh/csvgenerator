Description : Mockaroo limit download CSV file with Max 1000 row, JAR “Mackaroo-CSV-Generator” will allow you to download any number of rows based on pre-defined schema by dividing the needed rows number on chunks every chunk/request will get 1000 row then merge all result in one CSV file, removing all headers and only use first retrieved columns header and place ID column with incremental value of rows.  

Installation and instructions : 
1. <a href="https://drive.google.com/file/d/1Z3x14kJNixfFgGeI3W4rzc6EMf4s60MM/view?usp=sharing">Download JAR Mockaroo.jar</a>

2.Create free account on Mockaroo 

3.Open “SCHEMAS” and “Create new schema”
<img src="https://i.ibb.co/gS8MsRM/7c12e688-5ff5-41db-8cc8-ef3355753e99.png" border="0" height="200px">

4.Select schema data - Remove ID column as JAR will generate it by default”

5.Save schema and from the schema page get the schema URL as highlighted 
<img src="https://i.ibb.co/2PHrDL1/bf71ff20-4d62-4bd3-ab37-8d44a6cb7001.png" border="0" height="150px">


6-Open terminal and locate to the Mockaroo.jar location then run : 

`java -jar Mockaroo.jar <Schema-URL> <Number of rows to be generated>`

 File will be generated as : Data-timestamp.csv in the same folder contain the Jar file.

