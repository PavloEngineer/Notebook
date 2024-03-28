package com.example.notebook.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar

typealias FunctionForSnackbar = () -> Unit
abstract class BaseFragment<VBinding : ViewBinding>(
    private val inflaterMethod: (LayoutInflater, ViewGroup?, Boolean) -> VBinding
) : Fragment() {

    private val DURATION_OF_SNACKBAR = 1000

    private var _binding: VBinding? = null

    val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflaterMethod.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    protected fun showSnackbar(label: String, functionForDismissing: FunctionForSnackbar = { Unit }) {
        view?.let {
            Snackbar.make(
                it,
                label,
                DURATION_OF_SNACKBAR
            )
        }?.addCallback(object : Snackbar.Callback() {
            override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                super.onDismissed(transientBottomBar, event)
                functionForDismissing()
            }
        })?.show()
    }

    protected open fun setListeners() {}
}