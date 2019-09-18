# Team 5109 Deep Space

#### Getting Started With Our Code
In order to use our code, be sure to install Visual Studio Code using the FRC provided installer. It can be found [here](https://wpilib.screenstepslive.com/s/currentCS/m/java/l/1027503-installing-c-and-java-development-tools-for-frc). Also install the FRC update suite from [here](https://wpilib.screenstepslive.com/s/currentCS/m/java/l/1027504-installing-the-frc-update-suite-all-languages), and the CTRE Phoenix framework using the installer found [here](http://www.ctr-electronics.com/hro.html#product_tabs_technical_resources).

Once you have this done, open up FRC VS Code and create a new project, or import an Eclipse project. Open up the command palette with `ctrl + shift + p` and enter commands from there.

With a new project created, right click `build.gradle` from your project files and select `Manage Vendor Libraries`. Select `Install new libraries (offline)` and select the CTRE ones, and click OK.

You should be set to run code after that.

#### Organization of our Git repo
TESTING GIQTHUB
Our Git repo will be organized by modules. Separate subdirectories will exist for different modules.
Basic organization is shown below:
````
- RIO 
  - \java\src\org\team5109\frc\
    - IMU
      - IMU methods
    - Motor
      - Motor specific methods
    - Pneumatics
      - Pneumatic methods
    - Vision
       - Vision methods
    - Network Tables
  - Other languages (?)
- Raspberry Pi
  - Python code
- Android
- Robot.java
````
Each method should be uploaded onto new files in their respective folders. Keep this in mind while uploading code.

As of now, if you wish to upload code, upload it to your own branch and create a pull request to add it to master.

#### Guide to FRC VS Code and Driver Station
In order to run code, you must first connect to the bot through either our wifi network or an ethernet cable. Open Driver Station to make sure that you have comms.

![Image of Driver Station](https://i.imgur.com/WYklNE2.png)

An example of Driver Station is shown above with comms, robot code loaded, and joysticks connected. If these conditions are true, the little bars will appear green.

Right above that you can see the battery left on the bot, and to the left you can see PC battery and CPU usage.

Further to the left are options to use one of four different modes: `TeleOperated`, `Autonomous`, `Practice`, and `Test`. You can specify what mode does what in the code. Enable or disable code with the big enable and disable buttons.

You can run code from VS code in more than one way. Use the shortcut `shift + f5` to deploy code instantly. Alternatively, you can open the command palette and type in `Deploy Code` to deploy it.
