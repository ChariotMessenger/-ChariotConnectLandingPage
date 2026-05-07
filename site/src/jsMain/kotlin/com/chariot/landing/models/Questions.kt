package com.chariot.landing.models



enum class Questions(
    val qus: String,
    val ans: String,
) {
    First(
        qus = "What is Umail?",
        ans = """
            **Umail** is a fast and reliable on-demand delivery platform that connects customers with local vendors to deliver **food, groceries, and pharmaceutical products** right to your doorstep. 
            
            We make everyday essentials easily accessible with just a few taps on your phone.
        """.trimIndent(),
    ),

    Second(
        qus = "Does Umail deliver groceries?",
        ans = """
            ✅ **Yes!** Umail delivers fresh groceries from local stores near you. 
            
            You can order everything from:
            - 🥬 Fresh produce
            - 🥛 Dairy products
            - 🥤 Beverages
            - 🍝 Pantry staples
            - 🧼 Household essentials
            
            Just browse our vendor catalog, add items to your cart, and checkout - we'll handle the delivery!
        """.trimIndent(),
    ),

    Third(
        qus = "Will my groceries be fresh if I order on Umail?",
        ans = """
            🛡️ **Absolutely!** We partner with trusted local grocery vendors who maintain high quality standards. 
            
            Our delivery system ensures that:
            - 🌡️ Perishable items are handled with care
            - ⏱️ Delivered quickly to preserve freshness
            - 📞 Dedicated support team for quality concerns
            
            Your satisfaction is our priority!
        """.trimIndent(),
    ),

    Fourth(
        qus = "How do I sign up as a vendor on Umail?",
        ans = """
            📝 **Signing up as a vendor is easy!** 
            
            1. 📲 Download the Umail vendor app
            2. 🔘 Click 'Register as Vendor'
            3. 📋 Complete the registration process in 3 simple steps:
               - **Step 1:** Provide your business information (business name, address, location, and type of products)
               - **Step 2:** Create your account with email, phone number, and password
               - **Step 3:** Verify your OTP and start listing your products
            
            🎉 Once approved, you can start receiving orders immediately!
        """.trimIndent(),
    ),

    Fifth(
        qus = "How do I create an account on Umail?",
        ans = """
            👤 **Creating a Umail account is simple!**
            
            **Method 1 - Email Sign Up:**
            1. 📲 Download the Umail customer app
            2. 🔘 Tap 'Sign Up'
            3. 📧 Enter your email address
            4. 🔐 Create a password
            5. 📝 Provide basic information (name and phone number)
            6. ✉️ Verify your email with the OTP sent to your inbox
            
            **Method 2 - Google Sign Up:**
            - 🔑 Sign up instantly using your Google account for faster registration
            
            🚀 You're ready to start ordering!
        """.trimIndent(),
    ),

    Sixth(
        qus = "What is Service fee?",
        ans = """
            💰 **What is the service fee?**
            
            The service fee is a small charge added to each order that helps us maintain and improve our platform.
            
            **What does it cover?**
            - 🔄 Order processing
            - 💬 Customer support
            - ✅ Quality assurance
            - 🔒 Platform security
            - 🚚 Delivery coordination
            
            > **Note:** The service fee varies based on your order total and location, and is clearly displayed in your cart before checkout - so you'll always know exactly what you're paying!
        """.trimIndent(),
    )
    ;

    companion object {
        const val title = "Frequently asked Questions"

        // Helper function to get all questions as a list
        fun getAllQuestions(): List<Questions> = values().toList()

        // Helper function to find a question by its text
        fun findByQuestion(question: String): Questions? = values().find { it.qus.equals(question, ignoreCase = true) }

        // Helper function to get FAQ pairs for display
        fun getFaqPairs(): List<Pair<String, String>> = values().map { it.qus to it.ans }
    }
}