package texas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.TreeMap;

public class Hand{
	private ArrayList<Card> cards;
	// Hint: You may find that preprocessing the cards to group them by rank is helpful.
	// Hint: Also, feel free to add more auxiliary variables here.

	public Hand(ArrayList<Card> cards) {
		setCards(cards);
	}

	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public void setCards(ArrayList<Card> cards) {
		this.cards = new ArrayList<Card>(cards);
	}
	

	public boolean isPair() {
	    int cardRepeats = 0;
	    boolean isPair = false;
	    for(int i=0; i < this.getCards().size(); i++ )
	    {
		    for(int k=i+1; k < this.getCards().size(); k++)
		    {
		    	if (this.getCards().get(i).getRank() == this.getCards().get(k).getRank())
		    	{
	                cardRepeats++;
	                if(cardRepeats == 1)
	                	return cardRepeats == 1;
		    	}
		    }
	    }
	
	    return isPair;
	    
	}
	
	public boolean isTwoPairs() {
		int cardRepeats = 0;
	    boolean isTwoPair = false;
	    for(int i=0; i < this.getCards().size(); i++ )
	    {
		    for(int k=i+1; k < this.getCards().size(); k++)
		    {
	            if (this.getCards().get(i).getRank() == this.getCards().get(k).getRank())
	            {
	                cardRepeats++;
	                if(cardRepeats == 2)
	                    return cardRepeats == 2;
	            }
	        }
	    }
	    
	    return isTwoPair;
	}
	
	public boolean isThreeofKind() {
		int cardRepeats = 0;
	    boolean isThreeOfAKind = false;
	    for(int i=0; i < this.getCards().size(); i++)
	    {
		    for(int k=i+1; k < this.getCards().size(); k++)
		    {
		    	if (this.getCards().get(i).getRank() == this.getCards().get(k).getRank())
	            {
	                cardRepeats++;
	                if(cardRepeats == 3)
	                	return cardRepeats == 3;
	            }
	        }
	    }
	    return isThreeOfAKind;		
	}

	public boolean isStraight() {
		int noOfCardsInARow = 0;
	    boolean isAStraight = false;
	    for (int i = 0; i < this.getCards().size()-1; i++)
	    {
	        if(this.getCards().get(i).getRank() - this.getCards().get(i+1).getRank() == 1)
	        {
	            noOfCardsInARow++;
	            if(noOfCardsInARow == 4)
	                isAStraight = true;
	        } 
	        else
	            noOfCardsInARow = 0;
	    }
	    return isAStraight;
	}

	public boolean isFullHouse() {
	    boolean isThreeOfAKind = false;
	    boolean isTwoOfAKind = false;
	    if(this.getCards().get(0).getRank() == this.getCards().get(1).getRank() 
	    	&& this.getCards().get(0).getRank() == this.getCards().get(2).getRank())
	    {
//	    	isThreeOfAKind = true;
	    	if(this.getCards().get(3).getRank() == this.getCards().get(4).getRank() 	    		
	    		&& this.getCards().get(3).getRank() != this.getCards().get(2).getRank())
//		    	isTwoOfAKind = true;
	    		return true;
	    		
	    }
	    else if(this.getCards().get(2).getRank() == this.getCards().get(3).getRank() 
	    		&& this.getCards().get(2).getRank() == this.getCards().get(4).getRank())
	    {
//	    	isThreeOfAKind = true;
	    	if(this.getCards().get(0).getRank() == this.getCards().get(1).getRank() 
	    		&& this.getCards().get(1).getRank() != this.getCards().get(2).getRank() )
	    		return true;
//		    	isTwoOfAKind = true;
	    }
	    return (isTwoOfAKind && isThreeOfAKind);
	}

	public boolean isFourofKind() {
		 int cardRepeats = 0;
		 boolean isFourOfAKind = false;
		 for(int i=0; i < this.getCards().size(); i++)
		 {
		    for(int k=i+1; k < this.getCards().size(); k++)
		    {
		    	if (this.getCards().get(i).getRank() == this.getCards().get(k).getRank())
	            {
	                cardRepeats++;
	                if(cardRepeats == 5)
	                	return cardRepeats == 5;
	            }
	        }
		}
	    return isFourOfAKind;
	}
	
	public enum HandRank {
	
	    FOUR_OF_A_KIND,
	    FULL_HOUSE,
	    STRAIGHT,
	    THREE_OF_A_KIND,
	    TWO_PAIR,
	    PAIR,
	    HIGH_CARD;
	}
	
	public HandRank determineHandRank() {
	    
		if(this.isFourofKind())
	        return HandRank.FOUR_OF_A_KIND; 
		else if(this.isFullHouse())
	        return HandRank.FULL_HOUSE;
		else if(this.isStraight())
	        return HandRank.STRAIGHT;
	    else if(this.isThreeofKind())
	        return HandRank.THREE_OF_A_KIND;
	    else if(this.isTwoPairs())
	        return HandRank.TWO_PAIR;
	    else if(this.isPair())
	        return HandRank.PAIR;
	    else
	        return HandRank.HIGH_CARD;
	}
	
	public int compareTo(Hand hand){
		try
		{
			if(this.determineHandRank().name() == hand.determineHandRank().name())
			{
				if(this.determineHandRank().name() == "FOUR_OF_A_KIND")
				{
					if(this.getCards().get(3).getRank() < hand.getCards().get(3).getRank())
						return 1;
					else if(this.getCards().get(3).getRank() > hand.getCards().get(3).getRank())
						return -1;
					else 
					{
						if(this.getCards().get(0).getRank() == hand.getCards().get(0).getRank()
							&& this.getCards().get(4).getRank() < hand.getCards().get(4).getRank())
							return -1;
						else if(this.getCards().get(0).getRank() == hand.getCards().get(0).getRank()
							&& this.getCards().get(4).getRank() > hand.getCards().get(4).getRank())
							return 1;
						
						else if(this.getCards().get(4).getRank() == hand.getCards().get(4).getRank()
							&& this.getCards().get(0).getRank() < hand.getCards().get(0).getRank())
							return -1;
						else if(this.getCards().get(4).getRank() == hand.getCards().get(4).getRank()
							&& this.getCards().get(0).getRank() > hand.getCards().get(0).getRank())
							return 1;
						else return 0;
					}
				}
				else if(this.determineHandRank().name() == "FULL_HOUSE")
				{
					HashMap<Integer, Integer> repetitions = new HashMap<Integer, Integer>();

					  for (int g = 0; g < this.getCards().size(); g++)
					  {
					      int item = this.getCards().get(g).getRank();

					      if (repetitions.containsKey(item))
					          repetitions.put(repetitions.get(item) + 1,item);
					      else
					          repetitions.put(1, item);
					  }
					  
					HashMap<Integer, Integer> repetitions1 = new HashMap<Integer, Integer>();

					  for (int g = 0; g < hand.getCards().size(); g++)
					  {
					      int item = hand.getCards().get(g).getRank();

					      if (repetitions1.containsKey(item))
					          repetitions1.put(repetitions1.get(item) + 1,item);
					      else
					          repetitions1.put(1, item);
					  }
					NavigableMap<Integer, Integer> map = new TreeMap<Integer, Integer>(repetitions);
					NavigableMap<Integer, Integer> other = new TreeMap<Integer, Integer>(repetitions1);
					map.values().removeIf(Objects::isNull);
					other.values().removeIf(Objects::isNull);

					if(map.lastEntry().getValue() < other.lastEntry().getValue())
						return -1;
					else if(map.lastEntry().getValue() > other.lastEntry().getValue())
						return 1;
					else 
					{
						if(map.firstEntry().getValue() < other.firstEntry().getValue())
							return -1;
						else if(map.firstEntry().getValue() > other.firstEntry().getValue())
							return 1;
						else return 0;	
					}
				}
				else if(this.determineHandRank().name() == "STRAIGHT")
				{
					if(this.getCards().get(0).getRank() < hand.getCards().get(0).getRank())
						return -1;
					else if(this.getCards().get(0).getRank() > hand.getCards().get(0).getRank())
						return 1;
					else return 0;
				}
				else if(this.determineHandRank().name() == "THREE_OF_A_KIND")
				{
					if(this.getCards().get(2).getRank() < hand.getCards().get(2).getRank())
						return -1;
					else if(this.getCards().get(2).getRank() > hand.getCards().get(2).getRank())
						return 1;
					else 
					{
						if(this.getCards().get(0).getRank() == hand.getCards().get(0).getRank()
							&& this.getCards().get(3).getRank() < hand.getCards().get(3).getRank())
							return -1;
						else if(this.getCards().get(0).getRank() == hand.getCards().get(0).getRank()
							&& this.getCards().get(3).getRank() > hand.getCards().get(3).getRank())
							return 1;
						
						else if(this.getCards().get(1).getRank() == hand.getCards().get(1).getRank()
							&& this.getCards().get(3).getRank() == hand.getCards().get(3).getRank()
							&& this.getCards().get(0).getRank() < hand.getCards().get(0).getRank())
							return -1;
						else if(this.getCards().get(1).getRank() == hand.getCards().get(1).getRank()
							&& this.getCards().get(3).getRank() == hand.getCards().get(3).getRank()
							&& this.getCards().get(0).getRank() > hand.getCards().get(0).getRank())
							return 1;
						
						else if(this.getCards().get(4).getRank() == hand.getCards().get(4).getRank()
							&& this.getCards().get(0).getRank() < hand.getCards().get(0).getRank())
							return -1;
						else if(this.getCards().get(4).getRank() == hand.getCards().get(4).getRank()
							&& this.getCards().get(0).getRank() > hand.getCards().get(0).getRank())
							return 1;
						else return 0;
					}
				}
				else if(this.determineHandRank().name() == "TWO_PAIR")
				{
					HashMap<Integer, Integer> repetitions = new HashMap<Integer, Integer>();

					  for (int g = 0; g < this.getCards().size(); g++)
					  {
					      int item = this.getCards().get(g).getRank();

					      if (repetitions.containsKey(item))
					          repetitions.put(repetitions.get(item) + 1,item);
					      else
					          repetitions.put(1, item);
					  }
					  
					HashMap<Integer, Integer> repetitions1 = new HashMap<Integer, Integer>();

					  for (int g = 0; g < hand.getCards().size(); g++)
					  {
					      int item = hand.getCards().get(g).getRank();

					      if (repetitions1.containsKey(item))
					          repetitions1.put(repetitions1.get(item) + 1,item);
					      else
					          repetitions1.put(1, item);
					  }
					NavigableMap<Integer, Integer> map = new TreeMap<Integer, Integer>(repetitions);
					NavigableMap<Integer, Integer> other = new TreeMap<Integer, Integer>(repetitions1);
					map.values().removeIf(Objects::isNull);
					other.values().removeIf(Objects::isNull);

					if(map.lastEntry().getValue() < other.lastEntry().getValue())
						return -1;
					else if(map.lastEntry().getValue() > other.lastEntry().getValue())
						return 1;
					else
					{
						if(map.firstEntry().getValue() < other.firstEntry().getValue())
							return -1;
						else if(map.firstEntry().getValue() == other.firstEntry().getValue())
						{
							if(this.getCards().get(0).getRank() == hand.getCards().get(0).getRank() 
								&& this.getCards().get(4).getRank() == hand.getCards().get(4).getRank() 
								&& this.getCards().get(2).getRank() < hand.getCards().get(2).getRank())
								return -1;
							else if(this.getCards().get(0).getRank() == hand.getCards().get(0).getRank() 
									&& this.getCards().get(4).getRank() == hand.getCards().get(4).getRank() 
									&& this.getCards().get(2).getRank() > hand.getCards().get(2).getRank())
									return 1;
							else if(this.getCards().get(0).getRank() == hand.getCards().get(0).getRank() 
									&& this.getCards().get(3).getRank() == hand.getCards().get(3).getRank() 
									&& this.getCards().get(4).getRank() < hand.getCards().get(4).getRank())
								return -1;
							else if(this.getCards().get(0).getRank() == hand.getCards().get(0).getRank() 
									&& this.getCards().get(3).getRank() == hand.getCards().get(3).getRank() 
									&& this.getCards().get(4).getRank() > hand.getCards().get(4).getRank())
								return -1;
							else if(this.getCards().get(1).getRank() == hand.getCards().get(1).getRank() 
									&& this.getCards().get(4).getRank() == hand.getCards().get(4).getRank() 
									&& this.getCards().get(0).getRank() < hand.getCards().get(0).getRank())
								return -1;
							else if(this.getCards().get(1).getRank() == hand.getCards().get(1).getRank() 
									&& this.getCards().get(4).getRank() == hand.getCards().get(4).getRank() 
									&& this.getCards().get(0).getRank() > hand.getCards().get(0).getRank())
								return 1;
							else return 0;
						}	
					}
				}
				else if(this.determineHandRank().name() == "PAIR")
				{
					HashMap<Integer, Integer> repetitions = new HashMap<Integer, Integer>();

					  for (int g = 0; g < this.getCards().size(); g++)
					  {
					      int item = this.getCards().get(g).getRank();

					      if (repetitions.containsKey(item))
					          repetitions.put(repetitions.get(item) + 1,item);
					      else
					          repetitions.put(1, item);
					  }
					  
					HashMap<Integer, Integer> repetitions1 = new HashMap<Integer, Integer>();

					  for (int g = 0; g < hand.getCards().size(); g++)
					  {
					      int item = hand.getCards().get(g).getRank();

					      if (repetitions1.containsKey(item))
					          repetitions1.put(repetitions1.get(item) + 1,item);
					      else
					          repetitions1.put(1, item);
					  }
					NavigableMap<Integer, Integer> map = new TreeMap<Integer, Integer>(repetitions);
					NavigableMap<Integer, Integer> other = new TreeMap<Integer, Integer>(repetitions1);
					map.values().removeIf(Objects::isNull);
					other.values().removeIf(Objects::isNull);

					if(this.getCards().get(0).getRank() < hand.getCards().get(0).getRank())
						return -1;
					else if(this.getCards().get(0).getRank() > hand.getCards().get(0).getRank())
						return 1;
					else
					{
						if(this.getCards().get(0).getRank() == hand.getCards().get(0).getRank() 
							&& this.getCards().get(1).getRank() < hand.getCards().get(1).getRank())
							return -1;
						else if(this.getCards().get(0).getRank() == hand.getCards().get(0).getRank() 
							&& this.getCards().get(1).getRank() > hand.getCards().get(1).getRank())
							return 1;
						
						else if(this.getCards().get(1).getRank() == hand.getCards().get(1).getRank() 
								&& this.getCards().get(2).getRank() < hand.getCards().get(2).getRank())
								return -1;
						else if(this.getCards().get(1).getRank() == hand.getCards().get(1).getRank() 
								&& this.getCards().get(2).getRank() > hand.getCards().get(2).getRank())
							return 1;
						
						else if(this.getCards().get(2).getRank() == hand.getCards().get(2).getRank() 
							&& this.getCards().get(3).getRank() < hand.getCards().get(3).getRank())
							return -1;
						else if(this.getCards().get(2).getRank() == hand.getCards().get(2).getRank() 
							&& this.getCards().get(3).getRank() > hand.getCards().get(3).getRank())
							return 1;
						
						else if(this.getCards().get(3).getRank() == hand.getCards().get(3).getRank() 
							&& this.getCards().get(4).getRank() < hand.getCards().get(4).getRank())
							return -1;
						else if(this.getCards().get(3).getRank() == hand.getCards().get(3).getRank() 
							&& this.getCards().get(4).getRank() > hand.getCards().get(4).getRank())
								return 1;
						
						else if(this.getCards().get(4).getRank() == hand.getCards().get(4).getRank() 
							&& this.getCards().get(0).getRank() < hand.getCards().get(0).getRank())
							return -1;
						else if(this.getCards().get(4).getRank() == hand.getCards().get(4).getRank() 
							&& this.getCards().get(0).getRank() > hand.getCards().get(0).getRank())
								return 1;
						else return 0;
						
					}
				}
				else if(this.determineHandRank().name() == "HIGH_CARD")
				{
					if(this.getCards().get(0).getRank() < hand.getCards().get(0).getRank())
						return -1;
					else if(this.getCards().get(0).getRank() > hand.getCards().get(0).getRank())
						return 1;
					else
					{
						if(this.getCards().get(1).getRank() < hand.getCards().get(1).getRank())
							return -1;
						else if(this.getCards().get(1).getRank() > hand.getCards().get(1).getRank())
							return 1;
						else 
						{
							if(this.getCards().get(2).getRank() < hand.getCards().get(2).getRank())
								return -1;
							else if(this.getCards().get(2).getRank() > hand.getCards().get(2).getRank())
								return 1;
							else
							{
								if(this.getCards().get(3).getRank() < hand.getCards().get(3).getRank())
									return -1;
								else if(this.getCards().get(3).getRank() > hand.getCards().get(3).getRank())
									return 1;
								else
								{
									if(this.getCards().get(4).getRank() < hand.getCards().get(4).getRank())
										return -1;
									else if(this.getCards().get(4).getRank() > hand.getCards().get(4).getRank())
										return 1;
								}
							}
						}
					}
				}
			}
			else
			{
				if(this.determineHandRank().name() == "FOUR_OF_A_KIND")
				{
					return 1; 
				}
				else if(hand.determineHandRank().name() == "FOUR_OF_A_KIND")
				{
					return -1; 
				}
				
				if(this.determineHandRank().name() == "FULL_HOUSE")
				{
					return 1; 
				}
				else if(hand.determineHandRank().name() == "FULL_HOUSE")
				{
					return -1; 
				}
				
				if(this.determineHandRank().name() == "STRAIGHT")
				{
					return 1; 
				}
				else if(hand.determineHandRank().name() == "STRAIGHT")
				{
					return -1; 
				}
				
				if(this.determineHandRank().name() == "THREE_OF_A_KIND")
				{
					return 1; 
				}
				else if(hand.determineHandRank().name() == "THREE_OF_A_KIND")
				{
					return -1; 
				}
				
				if(this.determineHandRank().name() == "TWO_PAIR")
				{
					return 1; 
				}
				else if(hand.determineHandRank().name() == "TWO_PAIR")
				{
					return -1; 
				}
				
				if(this.determineHandRank().name() == "PAIR")
				{
					return 1; 
				}
				else if(hand.determineHandRank().name() == "PAIR")
				{
					return -1; 
				}
				
				if(this.determineHandRank().name() == "HIGH_CARD")
				{
					return 1; 
				}
				else if(hand.determineHandRank().name() == "HIGH_CARD")
				{
					return -1; 
				}

			}		
	
		}	
		catch(Exception except)
		{
			System.err.println("Error in compare: " + except.getMessage()); 
			System.exit(1);
		}
		return 0;
	}
}
