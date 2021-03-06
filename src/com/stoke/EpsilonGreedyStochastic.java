/* ************************************************************************************************ 
 * Copyright 2016 SUNY Binghamton
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this 
 * software and associated documentation files (the "Software"), to deal in the Software 
 * without restriction, including without limitation the rights to use, copy, modify, merge,
 * publish, distribute, sublicense, and/or sell copies of the Software, and to permit 
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or 
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR 
 * PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE 
 * FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR 
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER 
 * DEALINGS IN THE SOFTWARE.
 * ***********************************************************************************************/

package com.stoke;

import java.util.Random;

public class EpsilonGreedyStochastic extends StochasticPolicy { 

  protected static double EPSILON = 0.10;
  protected double _epsilon;
  protected Random _random = new Random();

  public EpsilonGreedyStochastic(MiniMachine bandit, Configuration[] configurations, double epsilon) {
    super(bandit, configurations);
    _epsilon = epsilon;
  }

  public boolean shouldRandomize() {
    return (_random.nextDouble() < _epsilon);
  }

  public Configuration stochasticSelect(int step) {
    return _configurations[_random.nextInt(_configurations.length)];
  } 

  public void learn() { }

  public StochasticPolicyType type() {
    return StochasticPolicyType.EPSILON_GREEDY_0;
  }
}

