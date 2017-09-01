package me.guaidaodl.common.ui.recyclerview

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import me.guaidaodl.common.BR

abstract class BaseDataBindingAdapter<Item, Delegate>:
	RecyclerView.Adapter<BaseDataBindingAdapter.BaseViewHolder<Item, Delegate>>() {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Item, Delegate> {
		val inflater = LayoutInflater.from(parent.context)
		val binding: ViewDataBinding
				= DataBindingUtil.inflate(inflater, viewType, parent, false)

		initView(binding)

		return BaseViewHolder(binding)
	}

	override final fun getItemViewType(position: Int): Int {
		return getLayoutId(position)
	}

	override fun onBindViewHolder(holder: BaseViewHolder<Item, Delegate>, position: Int) {
		val item = getItem(position)
		val delegate = getDelegate(position)

		holder.bind(item, delegate)
	}

	@LayoutRes abstract fun getLayoutId(position: Int): Int

	abstract fun getItem(position: Int): Item

	fun getDelegate(position: Int): Delegate? = null

	fun initView(binding: ViewDataBinding) {
	}

	class BaseViewHolder<in Item, in Delegate>(val binding: ViewDataBinding)
			: RecyclerView.ViewHolder(binding.root) {

		fun bind(item: Item?, delegate: Delegate?) {
			binding.setVariable(BR.item, item)
			binding.setVariable(BR.delegate, delegate)
		}
	}
}

class PropertyStub: BaseObservable() {
	@Bindable
	var item: String = ""
	@Bindable
	var delegate: String = ""
}