package space.cougs.ground.satellites;

public class CougSat1 extends CougSat {

	public CougSat1() {

	}

	public EPS getEps() {
		return eps;
	}

	public ECS getEcs() {
		return ecs;
	}

	public Comms getComms() {
		return comms;
	}

	public CDH getCdh() {
		return cdh;
	}

	public ADCS getAdcs() {
		return adcs;
	}

	private final ADCS adcs = new ADCS();
	private final CDH cdh = new CDH();
	private final Comms comms = new Comms();
	private final ECS ecs = new ECS();
	private final EPS eps = new EPS();

	@Override
	public int getID() {

		return 0x20;
	}

}
