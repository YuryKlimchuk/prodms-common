package com.hydroyura.prodms.common.mapper;

public interface TwoSideMapper<S,D> extends OneSideMapper<S,D> {

    S toSource(D destination);

}
