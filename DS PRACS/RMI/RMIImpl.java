import java.rmi.*;
import java.rmi.server.*;

class RmiImpl extends UnicastRemoteObject implements RmiExample
{
	public RmiImpl() throws RemoteException
	{}
	public int add(int a,int b) throws RemoteException
	{
		return a+b;
	}
}
