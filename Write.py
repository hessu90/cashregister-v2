#!/usr/bin/env python

import RPi.GPIO as GPIO
from mfrc522 import SimpleMFRC522
import sys, getopt

reader = SimpleMFRC522()

try:
        reader.write(sys.argv[1])
finally:
        GPIO.cleanup()