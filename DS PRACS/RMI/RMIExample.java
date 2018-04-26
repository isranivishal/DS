import java.rmi.*;

interface RmiExample extends Remote
{
	public int add(int a,int b) throws RemoteException;
}
