#!/usr/bin/env python

import os


if os.name == "nt":
    print("990390461325")
else:
    import RPi.GPIO as GPIO
    from mfrc522 import SimpleMFRC522

    reader = SimpleMFRC522()

    try:
            id, text = reader.read()
            print(id)
    finally:
            GPIO.cleanup()
