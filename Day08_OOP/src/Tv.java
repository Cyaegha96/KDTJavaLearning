
// TODO: Auto-generated Javadoc
/**
 * The Class Tv.
 */
public class Tv {

	/** The turn on. */
	private boolean turnOn;
	
	/** The Channel. */
	private int Channel;
	
	/** The volume. */
	private int volume;
	
	/** The brand. */
	private String brand;
	
	/**
	 * Instantiates a new tv.
	 */
	public Tv() {
		this.turnOn = false;
		this.Channel = 7;
		this.volume = 10;
		this.brand  = "SAMSUNG"; 
	}
	
	/**
	 * Gets the turn on.
	 *
	 * @return the turn on
	 */
	public boolean getTurnOn() {
		return turnOn;
	}
	
	/**
	 * Gets the volume.
	 *
	 * @return the volume
	 */
	public int getVolume() {
		return volume;
	}
	
	/**
	 * Gets the channel.
	 *
	 * @return the channel
	 */
	public int getChannel() {
		return Channel;
	}
	
	/**
	 * Gets the brand.
	 *
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}
	
	/**
	 * Power on.
	 */
	public void powerOn() {
		this.turnOn = true;
	}
	
	/**
	 * Sets the brand.
	 *
	 * @param brand the new brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	/**
	 * Sets the channel.
	 *
	 * @param channel the new channel
	 */
	public void setChannel(int channel) {
		Channel = channel;
	}
	
	/**
	 * Sets the volume.
	 *
	 * @param volume the new volume
	 */
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	
	/**
	 * Gets the tv info.
	 *
	 * @return the tv info
	 */
	public void getTvInfo() {
		System.out.println(getBrand()+" TV");
		System.out.println("볼륨: "+getVolume());
		System.out.println("채널: "+getChannel());
		if(this.turnOn) {
			System.out.println("TV는 켜진 상태입니다.");
		}else {
			System.out.println("TV는 꺼진 상태입니다.");
		}
	}
}
