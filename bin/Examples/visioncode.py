# HSV Calibration Code
import cv2
import numpy as np

def nothing(x):
    pass
camera = cv2.VideoCapture(0) 
cv2.namedWindow('Filtered Video')

h_lower,s_lower,v_lower = 0,0,0
h_upper,s_upper,v_upper = 255,255,255

# creating track bar
cv2.createTrackbar('h_lower', 'Filtered Video',h_lower,179,nothing)
cv2.createTrackbar('s_lower', 'Filtered Video',s_lower,255,nothing)
cv2.createTrackbar('v_lower', 'Filtered Video',v_lower,255,nothing)
cv2.createTrackbar('h_upper', 'Filtered Video',h_upper,179,nothing)
cv2.createTrackbar('s_upper', 'Filtered Video',s_upper,255,nothing)
cv2.createTrackbar('v_upper', 'Filtered Video',v_upper,255,nothing)

while True:
    (grabbed, frame) = camera.read()
    if not grabbed:
        break
    hsv = cv2.cvtColor(frame,cv2.COLOR_BGR2HSV)

    h_lower = cv2.getTrackbarPos('h_lower','Filtered Video')
    s_lower = cv2.getTrackbarPos('s_lower','Filtered Video')
    v_lower = cv2.getTrackbarPos('v_lower','Filtered Video')
    h_upper = cv2.getTrackbarPos('h_upper','Filtered Video')
    s_upper = cv2.getTrackbarPos('s_upper','Filtered Video')
    v_upper = cv2.getTrackbarPos('v_upper','Filtered Video')

    lower_set = np.array([h_lower, s_lower, v_lower])
    upper_set = np.array([h_upper, s_upper, v_upper])

    mask = cv2.inRange(hsv,lower_set, upper_set)
    res = cv2.bitwise_and(frame,frame,mask=mask) 
 
    cv2.imshow('fff',res) 
    k = cv2.waitKey(5) & 0xFF
    if k == 27:
        break

cap.release()
cv2.destroyAllWindows()
