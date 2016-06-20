There's a river that you need to cross without getting wet. Fortunately, this river has a series of stepping stones that run across it arranged non-uniformly generally. The distance between any 2 adjacent stones is some unit multiple, e.g., "#" is a stone and "-" is the river (water) and the unit distance, we can have the following:
  
    #--#---#--#----#--#
    --#---#----#---#-#--
    ---#----#---#--#----
 
Given any arrangement of stones, an initial velocity measured in unit distances, and being able to accelerate/decelerate +1/-1, or 0 when you've landed on a stepping stone, write code that will find a solution, if it exists, given an initial velocity (some nonnegative integer value) and some arrangement of stones along the river. "Velocity" in this sense is the number of steps you can move, so if your velocity is 4 you can move 4 steps. The problem starts with an initial velocity (may be 0) and at the bank of the river where you can choose +1, -1, or 0 acceleration.