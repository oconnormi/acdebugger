/**
 * Copyright (c) Codice Foundation
 *
 * <p>This is free software: you can redistribute it and/or modify it under the terms of the GNU
 * Lesser General Public License as published by the Free Software Foundation, either version 3 of
 * the License, or any later version.
 *
 * <p>This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details. A copy of the GNU Lesser General Public
 * License is distributed along with this program and can be found at
 * <http://www.gnu.org/licenses/lgpl.html>.
 */
package org.codice.acdebugger.common;

import java.security.Permission;
import java.util.Collections;
import java.util.Set;
import javax.annotation.Nullable;

/** Defines a Json object to represent service permission information. */
public class ServicePermissionInfo {
  /**
   * Set of permission strings corresponding to the service permission this information was created
   * for.
   */
  @Nullable // only because Boon may not set it as it bypasses our ctor and the final keyword
  private final Set<String> permissionStrings;

  /**
   * The {@link java.security.ProtectionDomain#implies(Permission)} result from the requested domain
   * and service permission.
   */
  @Nullable // only because Boon may not set it as it bypasses our ctor and the final keyword
  private final boolean implies;

  /**
   * A set of permission strings corresponding to the given permission which were individually
   * checked using {@link java.security.ProtectionDomain#implies(Permission)} and returned <code>
   * true</code>.
   */
  @Nullable // only because Boon may not set it as it bypasses our ctor and the final keyword
  private final Set<String> implied;

  public ServicePermissionInfo() {
    this.permissionStrings = Collections.emptySet();
    this.implies = false;
    this.implied = Collections.emptySet();
  }

  public ServicePermissionInfo(
      Set<String> permissionStrings, boolean implies, Set<String> implied) {
    this.permissionStrings = permissionStrings;
    this.implies = implies;
    this.implied = implied;
  }

  public Set<String> getPermissionStrings() {
    return (permissionStrings != null) ? permissionStrings : Collections.emptySet();
  }

  public boolean implies() {
    return implies;
  }

  public Set<String> getImpliedPermissionStrings() {
    return (implied != null) ? implied : Collections.emptySet();
  }
}
