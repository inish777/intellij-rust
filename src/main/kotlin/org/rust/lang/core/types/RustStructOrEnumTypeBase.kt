package org.rust.lang.core.types

import org.rust.lang.core.psi.RustStructOrEnumItemElement
import org.rust.lang.core.psi.typeParameters

abstract class RustStructOrEnumTypeBase(val typeArguments: List<RustType>) : RustTypeBase() {

    abstract val item: RustStructOrEnumItemElement

    override val typeParameterValues: Map<RustTypeParameterType, RustType>
        get() = item.typeParameters.zip(typeArguments)
            .mapNotNull {
                val (param, arg) = it
                RustTypeParameterType(param) to arg
            }.toMap()

}
