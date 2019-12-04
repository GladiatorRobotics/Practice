package RIO.java.src.org.team5109.frc.datafromandroid;
import java.io.*;
import java.net.*;
import java.util.StringTokenizer;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class hyperimu {
	TalonSRX leftMotor1 =  new TalonSRX(6); //6, 10, 5, 4
    TalonSRX leftMotor2 =  new TalonSRX(10);
    TalonSRX rightMotor1 =  new TalonSRX(5);//10
	TalonSRX rightMotor2 =  new TalonSRX(4);//10
	double yaw;
	int Idata;
	public double send_data(){
		return yaw;
	}
	public int getIdata(){
		//System.out.print(Idata);
		return Idata;
	}
	public void setIdata(int num){
		Idata = num;
	}
	public String[] data;
	public void receive() {	
			//System.out.println("1");
	    	DatagramPacket mDatagramPacket =null;
	    	DatagramSocket mDatagramSocket = null;
			InetAddress client_adress = null;
	        try {
				
	        	System.out.println("2");
	            client_adress = InetAddress.getByName("10.51.9.2");
	            System.out.println("4");
	        } catch (UnknownHostException e) {
	        	System.out.println("5");
	            //showDialog(R.string.error_invalidaddr);
	            System.out.println("Error getting my own IP?");
	           return ;
	        }
	        try {
	        	System.out.println("3");
	            mDatagramSocket = new DatagramSocket(5555, client_adress);
	            mDatagramSocket.setReuseAddress(true);
	            System.out.println("6");
	        } catch (SocketException e) {
	            mDatagramSocket = null;
	        	//showDialog(R.string.error_neterror);
	            return ;}
	        byte[] buf = new byte[256];
	        try {
	            mDatagramPacket = new DatagramPacket(buf, buf.length, client_adress, 5555);
	        } catch (Exception e) {
	        	mDatagramSocket.close();
	        	mDatagramSocket = null;
	        	//showDialog(R.string.error_neterror);
	        	return ;
	        }
	        
	        //BufferedWriter mBufferwriter = new BufferedWriter(new FileWriter("graph.csv"));
	        while(true)
	        {
	            try {
					
	            	//System.out.println("7");
	                mDatagramSocket.receive(mDatagramPacket);
	                //System.out.println("8");
	                String text = new String(mDatagramPacket.getData(),0, mDatagramPacket.getLength());
					
					//  System.out.println("9");
	               
				   data = text.split(",");
					yaw = Double.parseDouble(data[1]);
                    System.out.println(data[1]);
                    
				
	            } catch (Exception e) {
	                // TODO Auto-generated catch block
	            	System.out.println("9");
	                e.printStackTrace();
	                break;
				}
				

				
	        }
	    
	    
	       
	}
}
