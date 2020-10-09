/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package jakarta.faces.component.visit;

import jakarta.faces.FacesWrapper;
import jakarta.faces.context.FacesContext;

import java.util.Collection;
import java.util.Set;

/**
 * @since 2.0
 */
public abstract class VisitContextFactory implements FacesWrapper<VisitContextFactory>
{
    private VisitContextFactory delegate;

    @Deprecated
    public VisitContextFactory()
    {
    }

    public VisitContextFactory(VisitContextFactory delegate)
    {
        this.delegate = delegate;
    }
    
    public abstract VisitContext getVisitContext(FacesContext context, Collection<String> ids, Set<VisitHint> hints);

    public VisitContextFactory getWrapped()
    {
        return delegate;
    }
}