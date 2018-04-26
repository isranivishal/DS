import java.rmi.*;
import java.rmi.server.*;

class Server
{
	public static void main(String[] args) throws RemoteException
	{
		RmiImpl obj=new RmiImpl();
		try
		{
			Naming.rebind("add",obj);
		}
		catch(Exception e)
		{}
		
		System.out.println("Server started");
	}
}
