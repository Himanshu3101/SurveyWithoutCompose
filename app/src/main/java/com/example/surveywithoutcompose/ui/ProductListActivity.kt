package com.example.surveywithoutcompose.ui

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.surveywithoutcompose.R
import com.example.surveywithoutcompose.data.ApiResultHandler
import com.example.surveywithoutcompose.data.LoginData
import com.example.surveywithoutcompose.data.UserRequest
import com.example.surveywithoutcompose.databinding.ActivityProductListBinding
import com.example.surveywithoutcompose.viewModels.Welcome_VM
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductListActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<Welcome_VM>()
    lateinit var activityProductListBinding: ActivityProductListBinding
    lateinit var productListAdapter: ProductListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityProductListBinding =
            DataBindingUtil.setContentView(this@ProductListActivity, R.layout.activity_product_list)
        init()
        getProducts()
        observeProductData()
    }

    private fun init() {
        productListAdapter = ProductListAdapter()
        activityProductListBinding.list.apply { adapter = productListAdapter }
        activityProductListBinding.swipeRefreshLayout.setOnRefreshListener { getProducts() }
    }

    private fun getProducts() {
        val sigIn_Data = UserRequest("zxzx@.com", "111111", "zxzx@.com")
        mainViewModel.getProductsList(sigIn_Data)
    }

    private fun observeProductData() {
        mainViewModel.response.observe(this) { response ->
            val apiResultHandler = ApiResultHandler<LoginData>(
                this@ProductListActivity,
                onLoading = {
                    activityProductListBinding.progress.visibility = View.VISIBLE
                },
                onSuccess = { data ->
                    activityProductListBinding.progress.visibility = View.GONE
                    data?.let { productListAdapter.setProducts(it) }
                    activityProductListBinding.swipeRefreshLayout.isRefreshing = false
                },
                onFailure = {
                    activityProductListBinding.progress.visibility = View.GONE
                })
            apiResultHandler.handleApiResult(response)
        }
    }

}
