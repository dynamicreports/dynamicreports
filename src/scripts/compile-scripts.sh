#!/usr/bin/env bash

echo ttf-mscorefonts-installer msttcorefonts/accepted-mscorefonts-eula select true | sudo debconf-set-selections

sudo apt-get install ttf-mscorefonts-installer