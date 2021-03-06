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

package org.apache.myfaces.component.search;

import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.search.SearchExpressionContext;
import javax.faces.component.search.SearchExpressionHint;
import javax.faces.component.search.SearchKeywordContext;
import javax.faces.component.search.SearchKeywordResolver;
import org.apache.myfaces.core.api.shared.ComponentUtils;

/**
 *
 */
public class FormSearchKeywordResolver extends SearchKeywordResolver
{
    public static final String FORM_KEYWORD = "form";

    @Override
    public void resolve(SearchKeywordContext expressionContext, UIComponent current, String keyword)
    {
        expressionContext.invokeContextCallback(ComponentUtils.findClosest(UIForm.class, current));
    }
    
    @Override
    public boolean isResolverForKeyword(SearchExpressionContext searchExpressionContext, String keyword)
    {
        return FORM_KEYWORD.equalsIgnoreCase(keyword);
    }

    @Override
    public boolean isPassthrough(SearchExpressionContext searchExpressionContext, String keyword)
    {
        if (searchExpressionContext.getExpressionHints() != null &&
            searchExpressionContext.getExpressionHints().contains(SearchExpressionHint.RESOLVE_CLIENT_SIDE))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    @Override
    public boolean isLeaf(SearchExpressionContext searchExpressionContext, String keyword)
    {
        return false;
    }

}
