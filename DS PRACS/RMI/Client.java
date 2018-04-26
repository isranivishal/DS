import java.rmi.*;
import java.rmi.server.*;

class Client
{
	public static void main(String[] args) throws Exception
	{
		RmiExample r=(RmiExample)Naming.lookup("rmi://localhost/add");
		System.out.println("Sum is "+r.add(10,5));
	}
}
