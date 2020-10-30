#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Oct 29 19:05:19 2020

@author: dillonurry
"""
from flask import Flask#, request
from os import chdir 
import pandas as pd
import json

wd = "/Users/sid/Work/surprise-mechanic"
chdir(wd)

df = pd.read_pickle('data.pkl')

def n_random_orders(df, hod):
    
    store_list = df['store_name'][df['hod'] == hod].unique()
    appended_data = []
    
    for i in store_list: 
   
        temp_df = df[(df['hod'] == hod) & (df['store_name'] == i)]
        result_i = temp_df.sample(1)
        appended_data.append(result_i)
        
    appended_data = pd.concat(appended_data)       
        
    
    result = appended_data.to_json()
    parsed = json.loads(result)
    
    return json.dumps(parsed, indent=4) 

#result = n_random_orders(df, 21)
    
app = Flask(__name__)

@app.route("/")
def n_random_orders_api():
    return n_random_orders(df, 21)

if __name__ == "__main__":
    app.run()
