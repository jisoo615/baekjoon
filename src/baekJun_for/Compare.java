package baekJun_for;

public class Compare {
	int a, b;
 	String flag;
 	
 	public Compare(int A, int B) {
	this.a = A; this.b =B;
	
	if (a>b) this.flag= ">";
	else if (a<b) this.flag="<";
	else this.flag="==";

 	}

}
