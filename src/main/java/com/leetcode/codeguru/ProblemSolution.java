package com.leetcode.codeguru;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.lang.invoke.MethodHandles;

public interface ProblemSolution {

   static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());

   void validate();

}
