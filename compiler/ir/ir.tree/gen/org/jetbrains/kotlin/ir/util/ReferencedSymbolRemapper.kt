/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

// This file was generated automatically. See compiler/ir/ir.tree/tree-generator/ReadMe.md.
// DO NOT MODIFY IT MANUALLY.

package org.jetbrains.kotlin.ir.util

import org.jetbrains.kotlin.ir.declarations.*
import org.jetbrains.kotlin.ir.expressions.*
import org.jetbrains.kotlin.ir.symbols.*
import org.jetbrains.kotlin.ir.types.IrSimpleType

/**
 * Used to replace symbols that represent references to declarations other than the symbol's owner.
 *
 * Auto-generated by [org.jetbrains.kotlin.ir.generator.print.symbol.ReferencedSymbolRemapperInterfacePrinter]
 */
interface ReferencedSymbolRemapper {

    /**
     * Remaps symbols stored, e.g., in the following properties (not necessarily limited to those properties):
     * - [IrClass.sealedSubclasses]
     * - [IrScript.targetClass]
     * - [IrReplSnippet.stateObject]
     * - [IrReplSnippet.targetClass]
     * - [IrGetObjectValue.symbol]
     * - [IrCall.superQualifierSymbol]
     * - [IrInstanceInitializerCall.classSymbol]
     * - [IrClassReference.symbol]
     * - [IrSimpleType.classifier]
     */
    fun getReferencedClass(symbol: IrClassSymbol): IrClassSymbol

    /**
     * Remaps symbols stored, e.g., in the following properties (not necessarily limited to those properties):
     * - [IrFunctionWithLateBinding.correspondingPropertySymbol]
     * - [IrField.correspondingPropertySymbol]
     * - [IrScript.providedProperties]
     * - [IrScript.resultProperty]
     * - [IrSimpleFunction.correspondingPropertySymbol]
     * - [IrPropertyReference.symbol]
     * - [IrRichPropertyReference.reflectionTargetSymbol]
     */
    fun getReferencedProperty(symbol: IrPropertySymbol): IrPropertySymbol

    /**
     * Remaps symbols stored, e.g., in the following properties (not necessarily limited to those properties):
     * - [IrScript.importedScripts]
     * - [IrScript.earlierScripts]
     * - [IrClassReference.symbol]
     * - [IrSimpleType.classifier]
     */
    fun getReferencedScript(symbol: IrScriptSymbol): IrScriptSymbol

    /**
     * Remaps symbols stored, e.g., in the following properties (not necessarily limited to those properties):
     * - [IrConstructorCall.symbol]
     * - [IrConstantObject.constructor]
     * - [IrDelegatingConstructorCall.symbol]
     * - [IrEnumConstructorCall.symbol]
     * - [IrRawFunctionReference.symbol]
     * - [IrFunctionReference.symbol]
     * - [IrRichFunctionReference.reflectionTargetSymbol]
     * - [IrReturn.returnTargetSymbol]
     */
    fun getReferencedConstructor(symbol: IrConstructorSymbol): IrConstructorSymbol

    /**
     * Remaps symbols stored, e.g., in the following properties (not necessarily limited to those properties):
     * - [IrGetEnumValue.symbol]
     */
    fun getReferencedEnumEntry(symbol: IrEnumEntrySymbol): IrEnumEntrySymbol

    /**
     * Remaps symbols stored, e.g., in the following properties (not necessarily limited to those properties):
     * - [IrRawFunctionReference.symbol]
     * - [IrFunctionReference.symbol]
     * - [IrRichFunctionReference.reflectionTargetSymbol]
     * - [IrReturn.returnTargetSymbol]
     */
    fun getReferencedFunction(symbol: IrFunctionSymbol): IrFunctionSymbol = when (symbol) {
        is IrConstructorSymbol -> getReferencedConstructor(symbol)
        is IrSimpleFunctionSymbol -> getReferencedSimpleFunction(symbol)
    }

    /**
     * Remaps symbols stored, e.g., in the following properties (not necessarily limited to those properties):
     * - [IrCall.symbol]
     * - [IrPropertyReference.getter]
     * - [IrPropertyReference.setter]
     * - [IrLocalDelegatedPropertyReference.getter]
     * - [IrLocalDelegatedPropertyReference.setter]
     * - [IrRichFunctionReference.overriddenFunctionSymbol]
     * - [IrRawFunctionReference.symbol]
     * - [IrFunctionReference.symbol]
     * - [IrRichFunctionReference.reflectionTargetSymbol]
     * - [IrReturn.returnTargetSymbol]
     */
    fun getReferencedSimpleFunction(symbol: IrSimpleFunctionSymbol): IrSimpleFunctionSymbol

    /**
     * Remaps symbols stored, e.g., in the following properties (not necessarily limited to those properties):
     * - [IrPropertyReference.field]
     * - [IrGetField.symbol]
     * - [IrSetField.symbol]
     */
    fun getReferencedField(symbol: IrFieldSymbol): IrFieldSymbol

    /**
     * Remaps symbols stored, e.g., in the following properties (not necessarily limited to those properties):
     * - [IrLocalDelegatedPropertyReference.symbol]
     * - [IrRichPropertyReference.reflectionTargetSymbol]
     */
    fun getReferencedLocalDelegatedProperty(symbol: IrLocalDelegatedPropertySymbol): IrLocalDelegatedPropertySymbol

    /**
     * Remaps symbols stored, e.g., in the following properties (not necessarily limited to those properties):
     * - [IrLocalDelegatedPropertyReference.delegate]
     * - [IrGetValue.symbol]
     * - [IrSetValue.symbol]
     */
    fun getReferencedVariable(symbol: IrVariableSymbol): IrVariableSymbol

    /**
     * Remaps symbols stored, e.g., in the following properties (not necessarily limited to those properties):
     * - [IrRichPropertyReference.reflectionTargetSymbol]
     */
    fun getReferencedDeclarationWithAccessors(symbol: IrDeclarationWithAccessorsSymbol): IrDeclarationWithAccessorsSymbol = when (symbol) {
        is IrPropertySymbol -> getReferencedProperty(symbol)
        is IrLocalDelegatedPropertySymbol -> getReferencedLocalDelegatedProperty(symbol)
    }

    /**
     * Remaps symbols stored, e.g., in the following properties (not necessarily limited to those properties):
     * - [IrClassReference.symbol]
     * - [IrSimpleType.classifier]
     */
    fun getReferencedClassifier(symbol: IrClassifierSymbol): IrClassifierSymbol = when (symbol) {
        is IrClassSymbol -> getReferencedClass(symbol)
        is IrScriptSymbol -> getReferencedScript(symbol)
        is IrTypeParameterSymbol -> getReferencedTypeParameter(symbol)
    }

    /**
     * Remaps symbols stored, e.g., in the following properties (not necessarily limited to those properties):
     * - [IrClassReference.symbol]
     * - [IrSimpleType.classifier]
     */
    fun getReferencedTypeParameter(symbol: IrTypeParameterSymbol): IrClassifierSymbol

    /**
     * Remaps symbols stored, e.g., in the following properties (not necessarily limited to those properties):
     * - [IrReturn.returnTargetSymbol]
     */
    fun getReferencedReturnTarget(symbol: IrReturnTargetSymbol): IrReturnTargetSymbol = when (symbol) {
        is IrFunctionSymbol -> getReferencedFunction(symbol)
        is IrReturnableBlockSymbol -> getReferencedReturnableBlock(symbol)
    }

    /**
     * Remaps symbols stored, e.g., in the following properties (not necessarily limited to those properties):
     * - [IrReturn.returnTargetSymbol]
     */
    fun getReferencedReturnableBlock(symbol: IrReturnableBlockSymbol): IrReturnTargetSymbol

    /**
     * Remaps symbols stored, e.g., in the following properties (not necessarily limited to those properties):
     * - [IrGetValue.symbol]
     * - [IrSetValue.symbol]
     */
    fun getReferencedValue(symbol: IrValueSymbol): IrValueSymbol = when (symbol) {
        is IrValueParameterSymbol -> getReferencedValueParameter(symbol)
        is IrVariableSymbol -> getReferencedVariable(symbol)
    }

    /**
     * Remaps symbols stored, e.g., in the following properties (not necessarily limited to those properties):
     * - [IrGetValue.symbol]
     * - [IrSetValue.symbol]
     */
    fun getReferencedValueParameter(symbol: IrValueParameterSymbol): IrValueSymbol
}
