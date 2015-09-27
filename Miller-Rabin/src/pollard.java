import java.math.BigInteger;
import java.util.Vector;


public class pollard {

	
	
	public static BigInteger find_polard(BigInteger N, BigInteger B){
		
		BigInteger b = new BigInteger("2");
		BigInteger fail = new BigInteger("-1");
		BigInteger J,d;
		Vector<Integer> V1 = new Vector<Integer>();
		V1.add(1);
		System.out.println(V1);
		for(J = new BigInteger("2");J.compareTo(B)<=0;J= J.add(BigInteger.ONE)){
			
			b= b.pow(J.intValue());
			b = b.mod(N);
		}
			b = b.subtract(BigInteger.ONE);
			d= b.gcd(N);
			
		if(d.compareTo(BigInteger.ONE)>0 && d.compareTo(N)<0){
			return d;
		}
		else return fail;
		
		
	}
	
	
	public static void main(String[] args) {
		
		BigInteger b = new BigInteger("23");
		BigInteger N = new BigInteger("618240007109027021");
		
		System.out.println(find_polard(N,b));
			
		
		
	}

}
