package space.cougs.ground.utils;

import java.io.FileInputStream;
import java.io.IOException;

public class FileUtils {
  public static final long readNextBytes(FileInputStream file, int numberOfBytes) throws IOException {
    long buff = 0;

    while (numberOfBytes > 0) {
      buff = buff << 8 | file.read();
      numberOfBytes--;
    }

    return buff;
  }

  public static final int readTemp(FileInputStream file) throws IOException {
    return Units.rawToTemp(file.read());
  }

  public static final double readGeographicCoordinate(FileInputStream file) throws IOException {
    return Units.rawToGeographicCoordinate(readNextBytes(file, 4));
  }

  public static final double readEulerAngle(FileInputStream file) throws IOException {
    return Units.rawToAngle(readNextBytes(file, 2));
  }

  public static final double readCurrent(FileInputStream file) throws IOException {
    return Units.rawToCurrent(readNextBytes(file, 2));
  }

  public static final double readVoltage(FileInputStream file) throws IOException {
    return Units.rawToVoltage(readNextBytes(file, 2));
  }

  public static final long readTime(FileInputStream file) throws IOException {
    return Units.rawToTime(readNextBytes(file, 4));
  }

  public static final double readPower(FileInputStream file) throws IOException {
    return Units.rawToPower(readNextBytes(file, 2));
  }

  public static final double readDecibel(FileInputStream file) throws IOException {
    return Units.rawToDecibels(readNextBytes(file, 2));
  }

  public static final int readFrequency(FileInputStream file) throws IOException {
    return Units.rawToFrequency(readNextBytes(file, 3));
  }
}
