package esercizio3;

public class Data<T> {

	private T label;
	private float priority;
	/**
     * constructor
     * @param value
     * @param priority
     */
	public Data(T label, float priority){
		this.label = label;
		this.priority = priority;
	}
	/**
     * return the label
     * @return 
     */
	public T getLabel(){
		return this.label;
	}
	/**
     * return the priority
     * @return 
     */
	public double getPriority(){
		return this.priority;
	}
	/**
     * set the value
     * @param value
     */
	public void setLabel(T label){
		this.label = label;
	}
	/**
     * set the priority
     * @param value
     */
	public void setPriority(float priority){
		this.priority = priority;
	}
	
	@Override
	public String toString(){
		return "(" + label + "; " + priority + ")";
	}
	
	@Override
	public boolean equals(Object obj){
		if(this == null || obj == null) return false;
		if(obj.getClass() != this.getClass()) return false;
		
		Data<?> data = (Data<?>) obj;
		if(data.getLabel().equals(this.label)) return true;
		return false;
	}

}
