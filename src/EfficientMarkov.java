import java.util.*;

public class EfficientMarkov extends BaseMarkov {
	private Map<String,ArrayList<String>> myMap;
	
	public EfficientMarkov(){
		this(3);
	}

	public EfficientMarkov(int order) {
		super(order);
		myMap = new HashMap<>();
	}

	@Override
	public void setTraining(String text) {
		super.setTraining(text);
		myMap.clear();
		String current = "";
		String nextLetter = "";
		for(int i = 0; i < text.length() - myOrder + 1; i++){
			current = text.substring(i, i + myOrder);
			if(i + myOrder >= text.length()){
				nextLetter = PSEUDO_EOS;
			} else{
				nextLetter = text.substring(i + myOrder, i + myOrder + 1);
			}

			if(!myMap.containsKey(current)){
				myMap.put(current, new ArrayList<String>());
			}
			myMap.get(current).add(nextLetter);
		}
	}
	@Override
	public ArrayList<String> getFollows(String key) {
		return myMap.get(key);
	}
}	
