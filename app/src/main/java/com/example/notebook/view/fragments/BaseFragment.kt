package com.example.notebook.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.notebook.view.utils.Constants.MILLIS_DURATION
import com.google.android.material.snackbar.Snackbar

// TODO: Snack wrong
typealias FunctionForSnack = () -> Unit
abstract class BaseFragment<VBinding : ViewBinding>(
    private val inflaterMethod: (LayoutInflater, ViewGroup?, Boolean) -> VBinding
) : Fragment() {

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

    // TODO: Delete
    protected fun showSnackBar(label: String, actionById: Int, functionForAction: FunctionForSnack) {
        view?.let {
            Snackbar.make(
                it,
                label,
                MILLIS_DURATION
            )
        }?.setAction(actionById) {
            functionForAction()
        }?.show()
    }

    // TODO: Change modifiers access
    abstract fun setListeners()
}