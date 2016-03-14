#!/bin/bash
#
# Run performance test

${jmeter} -n -t bowling-app-jmeter.jmx -l bowling-app-jmeter-results.jtl -JHost=$1 -Jport=$2 
