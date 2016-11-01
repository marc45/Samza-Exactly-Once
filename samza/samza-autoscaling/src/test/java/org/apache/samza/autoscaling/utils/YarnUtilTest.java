/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.samza.autoscaling.utils;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class YarnUtilTest {

  @Test
  public void handleJsonArraysAsWellAsStrings() throws IOException {
    YarnUtil yarnUtil = new YarnUtil("rm", 0);
    List<Map<String, String>> applications = yarnUtil.parseYarnApplications(IOUtils.toString(getClass().getClassLoader().getResourceAsStream("exampleResourceManagerOutput.json")));
    assertEquals("RUNNING", applications.get(0).get("state"));
  }
}
