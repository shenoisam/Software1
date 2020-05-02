# Software1

## Description
This repo contains code for the CShare EHR. This EHR was developed in order to assist healthcare providers manage their practice. 

## Run Program 
1. Clone our repository using the following command 
`git clone <url>`
2. Set up mysql. Mysql is a depedency to run this program. Please have mysql installed on your computer localy to run this program
3. Run the sql script. In the code/ directory, there is a file called `sqlScript.sql` . Please run this file after connecting to your mysql database. It creates a user called CShareAdmin and a CShare database in mysql which the program will then use to connect. 
4. Run the program. You can run the program either by running the provided jar file. 
`java -jar CShare.jar` 
5. 3 test users are loaded into the database as part of the script - testuser@test.com, testuser1@test.com, testuser2@test.com - which are a doctor, staff member, and patient respecitively. The password for all three of these users is Test. 


## Authors
This program was created by the following authors

* John Harrison 
* Jordan Hurt
* Mattew Morris 
* Alejandro Navarro
* Sam Shenoi 
* Katie Wokoek 

## Website 
A website containing documentation, presentations, hours worked, and other fun stuff can be found at https://shenoisam.github.io/Software1/
