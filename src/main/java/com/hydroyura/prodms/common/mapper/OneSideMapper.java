package com.hydroyura.prodms.common.mapper;

public interface OneSideMapper<S,D> {

    D toDestination(S source);

}
