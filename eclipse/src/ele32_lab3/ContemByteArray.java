package ele32_lab3;

public class ContemByteArray {
	public byte[] array;
	
	public ContemByteArray(byte[] array) {
		this.array = array;
	}
	
	@Override
	public int hashCode() {
		int res = 0;
		for (byte elem: array)
			res += elem;
		return res;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof ContemByteArray) {
			ContemByteArray obj = (ContemByteArray) o;
			if (this.array.length == obj.array.length) {
				for (int i=0; i<array.length; i++) {
					if (array[i] != obj.array[i])
						return false;
				}
				return true;
			}
		}
		return false;
	}
}
