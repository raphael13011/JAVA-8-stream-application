
public enum Mention {
	BIEN, ASSEZ_BIEN,TRES_BIEN, BOF;
	public static Mention find(double average) {	
		 if (average >= 12 && average < 14) {
		        return ASSEZ_BIEN;
		    } else if(average >= 14 && average < 16) {
		        return BIEN;
		    } else if (average >= 16) {
		        return TRES_BIEN;
		    } else {
		        return BOF;
		    }
	}
}
