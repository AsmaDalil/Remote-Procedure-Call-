from unittest import case
import PIL.Image as Image
import io
from zeep import Client
from datetime import datetime

RemoteAccess = Client('src/main/resources/RemoteAccessService.wsdl').service
Choice = 0
#Menu
Choice = int("Please enter your prefered choice: \n\t\t\t'1' : To list the processes running in the remote system \n\t\t\t'2' :To get the screenshot of the remote system \n\t\t\t'3' : To reboot the remote system \n\t\t\t'4' : To quit \n")

def input(Choice):
    match Choice :
        

        case 1 :
                List = RemoteAccess.getRunningProcess()
                for i in List:
                    print(i)
                print("Operation successful ...")
        
        case 2 :
            
                ImageBytes = bytearray(RemoteAccess.GetCapture())
                image = Image.open(io.BytesIO(ImageBytes))
                now = datetime.now()
                dt_string = "my_scr" + now.strftime("%Y_%m_%d_%H_%M_%S") + ".jpg"
                image.save(dt_string)
                print("\n\tOperation successful!\n")

        case 3 :
            
                RemoteAccess.reboot()
                print("\n\tOperation successful!\n")

       
            

        case 4 : 
                print("\nBy\t")
                return
            #do nothing


        case unknown_command :
                #Default case
                print("\nInvalid input! Please try again! \nUnknown Command : {unknown_command}")
