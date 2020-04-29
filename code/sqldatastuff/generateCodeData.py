# This is a python script to generate data for the insurance codes to insert into the database form the Medicade codes
# 
# Author: Sam Shenoi
# Version: 1
# Date Last Modified: 4/22/2020

import sys
import re
def main():
   file = open(sys.argv[1], "r");
   ty = ""
   #print("USE CSHARE;\n DELETE FROM Test; ")
   for line in file: 
      if "TYPE:" in line:
          ty = line.split("TYPE:")[1]
      else:
          li = line.split("|")
          if len(li) > 1: 
            li[1] = re.sub("\n", "",li[1])
            li[0] = re.sub("\n", "",li[0])
            ty = re.sub("\n", "", ty)
            sqlstatement = "INSERT INTO Test (Name, Type, InsuranceCode) VALUES ('" + li[1] + "','" + ty + "','" + li[0] + "'); " 
            print(sqlstatement )
   file.close() 





if __name__ =="__main__":
    main()