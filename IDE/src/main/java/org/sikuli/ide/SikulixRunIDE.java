/*
 * Copyright (c) 2010-2018, sikuli.org, sikulix.com - MIT license
 */

package org.sikuli.ide;

import org.sikuli.basics.Debug;
import org.sikuli.script.RunTime;

public class SikulixRunIDE {

  static String osName = System.getProperty("os.name").substring(0, 1).toLowerCase();

  public static void main(String[] args) {

    if (args.length > 0 && args[0].startsWith("-v")) {
      String argV = args[0];
      long start = 0;
      if (argV.length() > 2) {
        try {
          start = Long.parseLong(args[0].substring(2));
        } catch(Exception ex) { }
        Debug.setWithTimeElapsed(start);
        args[0] = "-v";
      } else {
        Debug.setWithTimeElapsed();
      }
      Debug.setDebugLevel(3);
      Debug.globalTraceOn();
      Debug.setStartWithTrace();
      Debug.log(3,"Sikulix: starting IDE");
    }

    if ("m".equals(osName)) {
      Sikulix.prepareMac();
    }

    RunTime runTime = RunTime.get(RunTime.Type.IDE, args);

    SikuliIDE.run(runTime, args);

    Debug.logp("");
  }
}
