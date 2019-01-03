package space.cougs.ground.satellites;

public abstract class CougSat {

	public abstract int getID();

	private final ADCS adcs = new ADCS();
	private final CDH cdh = new CDH();
	private final Comms comms = new Comms();
	private final ECS ecs = new ECS();
	private final EPS eps = new EPS();
	
	public ADCS getAdcs() {
		return adcs;
	}

	public CDH getCdh() {
		return cdh;
	}

	public Comms getComms() {
		return comms;
	}

	public ECS getEcs() {
		return ecs;
	}

	public EPS getEps() {
		return eps;
	}

}
